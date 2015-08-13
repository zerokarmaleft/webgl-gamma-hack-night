(ns gamma-hack-night.core
  (:require
   [gamma.api     :as g]
   [gamma.program :as p]
   [gamma-driver.api :as gd]
   [gamma-driver.drivers.basic :as driver]))

(def position (g/attribute "posAttr" :vec2))

(defn example-program []
  (p/program
   {:vertex-shader   {(g/gl-position)   (g/vec4 position 0 1)}
    :fragment-shader {(g/gl-frag-color) (g/vec4 1 0 0 1)}}))

(defn example-data []
  {position [[-0.5 -0.5] [0.5 -0.5] [0 0]]})

(defn example-driver []
  (driver/basic-driver
   (-> (.getElementById js/document "gl-canvas")
       (.getContext "webgl"))))

(defn main []
  (let [driver  (example-driver)
        program (example-program)
        data    (example-data)]
    (gd/draw-arrays driver
                    (gd/bind driver program data)
                    {})))

(main)
