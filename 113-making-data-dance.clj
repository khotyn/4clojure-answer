(fn [& coll]
  (reify
    java.lang.Object
    (toString [this]
      (apply str (interpose ", " (sort coll))))
    clojure.lang.Seqable
    (seq [this]
      (letfn [(step [coll result]
                (if (seq coll)
                  (let [head (first coll)]
                    (if (some #{head} result)
                      (step (next coll) result)
                      (step (next coll) (concat result [head]))))
                  result))]
        (step coll nil)))))