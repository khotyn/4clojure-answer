(fn [n]
  (letfn [(step [coll]
            (let [head (first coll)]
              (lazy-seq (cons head (step (filter #(pos? (mod % head)) coll))))))]
    (take n (step (range 2 Long/MAX_VALUE)))))