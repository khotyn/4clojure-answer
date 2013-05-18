(fn [pred k coll]
  (if (seq coll)
    (let [temp-result (map #(if (apply pred %) [(first %) k (last %)] %) (partition 2 1 coll))]
      (letfn [(step [coll]
                (if (seq coll)
                  (lazy-cat (drop-last (first coll)) (step (next coll)))))]
        (lazy-cat (step temp-result) [(last coll)])))))