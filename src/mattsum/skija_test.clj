(ns mattsum.skija-test
  (:import
   [org.jetbrains.skija
    FontMgr FontStyle Font Typeface
    Canvas Paint Surface])
  (:require [clojure.java.io :as io]
            #_[cljfx.platform :as platform]
            #_[cljfx.api :as fx])
  (:import [javafx.application Platform]))

(defn color [^long l]
  (.intValue (Long/valueOf l)))

(defn create-image-with-text []
  (let [[width height] [300 300]
        font (let [font-face (.matchFamilyStyle (FontMgr/getDefault)
                                                "Consolas" FontStyle/NORMAL)
                   font (Font. ^Typeface font-face )]
               font)
        paint (doto (Paint.)
                (.setColor (color 0xFF000000)))]
    (io/copy
     (let [surf (Surface/makeRasterN32Premul width height)
        canv (.getCanvas surf)]
       (.drawString ^Canvas canv
                     "The 2Text"
                     50 50
                     ^Font font
                     ^Paint paint)
    (-> (.makeImageSnapshot surf)
        .encodeToData
        .getBytes))
     (java.io.File. "/home/matthys/tmp/output.png"))))

(comment
  (Platform/startup #(Platform/setImplicitExit false))
  (create-image-with-text))

(defn greet
  "Callable entry point to the application."
  [data]
  (println "Testing")
  (Platform/startup #(Platform/setImplicitExit false))
  (create-image-with-text)
  (println "Worked"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (greet {:name (first args)}))
