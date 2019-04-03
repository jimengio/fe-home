
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
            [app.schema :as schema]
            [composer.core :refer [render-markup extract-templates]]
            [shadow.resource :refer [inline]]
            [cljs.reader :refer [read-string]]
            [clojure.string :as string])
  (:require-macros [clojure.core.strint :refer [<<]]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel)
       states (:states store)
       templates (extract-templates (read-string (inline "composer.edn")))]
   (div
    {:style (merge ui/global {:padding 40})}
    (render-markup
     (get templates "container")
     {:data [{:title "DevTools",
              :projects (->> schema/projects (filter (fn [x] (= :devtool (:kind x)))))}
             {:title "Docs",
              :projects (->> schema/projects (filter (fn [x] (= :docs (:kind x)))))}
             {:title "Router",
              :projects (->> schema/projects (filter (fn [x] (= :router (:kind x)))))}],
      :templates templates,
      :level 1}
     (fn [d! op param options]
       (when dev? (println "Action" op param (pr-str options)))
       (case op
         :input (d! :input (:value options))
         :submit (when-not (string/blank? (:input store)) (d! :submit nil))
         :remove (d! :remove param)
         (do (println "Unknown op:" op)))))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
