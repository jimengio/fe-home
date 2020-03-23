
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp >> list-> a <> div button textarea span img defeffect]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]
            [app.schema :as schema]
            [shadow.resource :refer [inline]]
            [cljs.reader :refer [read-string]]
            [clojure.string :as string])
  (:require-macros [clojure.core.strint :refer [<<]]))

(defeffect
 effect-focus
 ()
 (action el *local)
 (when (= action :mount)
   (let [target (.querySelector el ".touch-item")] (if (some? target) (.focus target)))))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel)
       states (:states store)
       projects (read-string (inline "projects.edn"))]
   [(effect-focus)
    (div
     {:style (merge ui/global {:padding 40})}
     (list->
      {}
      (->> projects
           (map-indexed
            (fn [idx category]
              [idx
               (div
                {}
                (div
                 {}
                 (<>
                  (:title category)
                  {:font-size 32,
                   :font-family ui/font-fancy,
                   :color (hsl 0 0 86),
                   :font-weight 300}))
                (list->
                 {}
                 (->> (:projects category)
                      (map-indexed
                       (fn [idx project]
                         [idx
                          (div
                           {:style (merge
                                    ui/row-middle
                                    {:background-color (hsl 200 20 99),
                                     :border (str "1px solid " (hsl 0 0 94)),
                                     :display :inline-flex,
                                     :margin 8,
                                     :min-width 160,
                                     :padding 8,
                                     :vertical-align :top,
                                     :cursor :pointer}),
                            :tab-index 0,
                            :on-click (fn [e d! m!]
                              (set! (.-href js/location) (:ui project))),
                            :on-keydown (fn [e d! m!]
                              (when (= 13 (:key-code e))
                                (set! (.-href js/location) (:ui project)))),
                            :class-name "touch-item"}
                           (if (some? (:logo project))
                             (img
                              {:src (:logo project),
                               :style {:width 40, :height 40, :margin-right 8}}))
                           (div
                            {:style ui/column}
                            (<>
                             (:title project)
                             {:color (hsl 200 80 60),
                              :font-size 16,
                              :font-family ui/font-fancy})
                            (a
                             {:href (:repo project),
                              :inner-text "repo",
                              :target "_blank",
                              :style {:text-decoration :none,
                                      :color (hsl 200 40 70),
                                      :line-height "16px",
                                      :font-size 12,
                                      :align-self :flex-start},
                              :on-click (fn [e d! m!] ),
                              :tab-index -1})))])))))]))))
     (when dev? (comp-reel (>> states :reel) reel {})))]))
