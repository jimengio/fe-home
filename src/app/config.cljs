
(ns app.config )

(def cdn?
  (cond
    (exists? js/window) false
    (exists? js/process) (= "true" js/process.env.cdn)
    :else false))

(def dev?
  (let [debug? (do ^boolean js/goog.DEBUG)]
    (cond
      (exists? js/window) debug?
      (exists? js/process) (not= "true" js/process.env.release)
      :else true)))

(def site
  {:dev-ui "http://localhost:8100/main.css",
   :release-ui "//fe.jimu.io/favored-fonts/main.css",
   :cdn-url "/fe-home/",
   :title "Fe home page",
   :icon "https://fe.jimu.io/logo/jimeng-360x360.png",
   :storage-key "fe-home"})
