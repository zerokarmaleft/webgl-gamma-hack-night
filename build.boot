(set-env!
 :source-paths
 #{"src/clj" "src/cljs"}

 :dependencies
 '[[org.clojure/clojurescript "0.0-3308"]
   [pandeiro/boot-http        "0.6.3-SNAPSHOT"]
   [kovasb/gamma              "0.0-135"]
   [kovasb/gamma-driver       "0.0-49"]
   [adzerk/boot-cljs          "0.0-3308-0"]
   [adzerk/boot-cljs-repl     "0.1.10-SNAPSHOT"]
   [adzerk/boot-reload        "0.3.1"]])

(require '[adzerk.boot-cljs      :refer :all]
         '[adzerk.boot-cljs-repl :refer :all]
         '[adzerk.boot-reload    :refer :all]
         '[pandeiro.boot-http    :refer :all])

(deftask start-dev
  "Start all the things!"
  []
  (comp (watch)
        (serve :dir ".")
        (reload)
        (cljs-repl)
        (cljs :compiler-options {:source-map    true
                                 :optimizations :none})))
