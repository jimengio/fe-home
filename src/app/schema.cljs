
(ns app.schema )

(def projects
  [{:title "UI Libraries",
    :projects [{:title "Jasmin UI",
                :repo "https://github.com/jimengio/jasmin-ui",
                :ui "http://fe.jimu.io/jasmin-ui/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}
               {:title "Mescal UI",
                :repo "https://github.com/jimengio/mescal-ui",
                :ui "http://fe.jimu.io/mescal-ui/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}
               {:title "Meson Form",
                :repo "https://github.com/jimengio/meson-form",
                :ui "http://fe.jimu.io/meson-form/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}
               {:title "Rough Table",
                :repo "https://github.com/jimengio/rough-table",
                :ui "http://fe.jimu.io/rough-table/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}
               {:title "Meson Display",
                :repo "https://github.com/jimengio/meson-display",
                :ui "http://fe.jimu.io/meson-display/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}]}
   {:title "DevTools",
    :projects [{:title "Locales Editor",
                :repo "https://github.com/jimengio/locales-editor",
                :ui "http://fe.jimu.io/locales-editor/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}
               {:title "Rebase Hell",
                :repo "https://github.com/jimengio/rebase-hell",
                :ui "http://fe.jimu.io/rebase-hell/",
                :logo "http://cdn.tiye.me/logo/rebase-hell.png"}
               {:title "Dev Apps Switcher",
                :repo "https://github.com/jimengio/dev-switcher",
                :ui "http://fe.jimu.io/dev-switcher/",
                :logo "http://cdn.tiye.me/logo/dev-switcher.png"}
               {:title "VSCode Snippets",
                :repo "https://github.com/jimengio/jm-snippets",
                :ui "https://github.com/jimengio/jm-snippets",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}
               {:title "Shopfloor Simulator",
                :repo "https://github.com/jimengio/shopfloor-simulator",
                :ui "http://fe.jimu.io/shopfloor-simulator/",
                :logo "http://cdn.tiye.me/logo/shopfloor-simulator.png"}]}
   {:title "Icons",
    :projects [{:title "Jimo Icons",
                :repo "https://github.com/jimengio/jimo-icons",
                :ui "http://fe.jimu.io/jimo-icons/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}
               {:title "FontAwesome finder",
                :repo "https://github.com/jimengio/fontawesome-finder",
                :ui "http://fe.jimu.io/fontawesome-finder/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}]}
   {:title "Router",
    :projects [{:title "Nav Code Generator",
                :repo "https://github.com/jimengio/nav-code-generator",
                :ui "http://fe.jimu.io/nav-code-generator/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png",
                :kind :router}
               {:title "Ruled Router Viewer",
                :repo "https://github.com/jimengio/ruled-router-viewer",
                :ui "http://fe.jimu.io/ruled-router-viewer/",
                :logo "http://cdn.tiye.me/logo/jimeng-360x360.png"}]}])

(def store {:states {}, :content ""})
