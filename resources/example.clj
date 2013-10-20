(println "EXAMPLE")

(use 'seesaw.core)
(use 'clojure.core)

(baldric-app (fn [display]
  (let [greeting (seesaw.core/label "hello from example!")]
    (do
      (println "derp")
      (display (seesaw.core/flow-panel :items [greeting]))))))
