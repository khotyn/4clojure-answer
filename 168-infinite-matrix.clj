(fn infinite-matrix
  ([f]
    (infinite-matrix f 0 0))
  ([f m n]
    (letfn [(inner [i j]
              (lazy-seq (cons (f i j) (inner i (inc j)))))
            (outer [i]
              (lazy-seq (cons (inner i n) (outer (inc i)))))]
      (outer m)))
  ([f m n s t]
    (take s (map #(take t %) (infinite-matrix f m n)))))
