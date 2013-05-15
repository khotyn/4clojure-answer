(fn my-reduction
  ([f coll]
    (letfn [(step [f coll]
              (if (nil? (second coll))
                []
                (lazy-seq
                  (let [mid-result (f (first coll) (second coll))]
                    (cons
                      mid-result
                      (step f (cons mid-result (drop 2 coll))))))))]
      (cons (first coll) (step f coll))))
  ([f val coll]
    (my-reduction f (cons val coll))))