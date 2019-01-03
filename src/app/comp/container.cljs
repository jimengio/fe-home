
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> list-> a <> div button textarea span]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]
            [app.schema :as schema])
  (:require-macros [clojure.core.strint :refer [<<]]))

(defcomp
 comp-project
 (project)
 (a
  {:class-name "project",
   :style (merge
           ui/column
           {:border (<< "1px solid ~(hsl 0 0 90)"),
            :padding 8,
            :background-color (hsl 0 0 97),
            :margin 16,
            :display :inline-flex,
            :min-width 200,
            :text-decoration :none}),
   :href (:ui project)}
  (div
   {}
   (span
    {:style {:font-size 16, :font-family ui/font-fancy, :color (hsl 200 80 50)},
     :inner-text (:title project),
     :tab-index nil}))
  (div
   {}
   (span
    {:style {:color (hsl 0 0 50), :font-size 13, :cursor :pointer},
     :on-click (fn [e d! m!] (.open js/window (:repo project))),
     :inner-text "Repo"}))))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/row)}
    (list->
     {:style {:padding 40}}
     (->> schema/projects (map (fn [project] [(:repo project) (comp-project project)]))))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
