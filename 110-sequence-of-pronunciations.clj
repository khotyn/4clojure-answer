(fn seq-of-pronunciations [coll]
  (lazy-seq
    (let [next-coll (apply concat (map #(vec [(count %) (first %)]) (partition-by #(if true %) coll)))]
      (cons next-coll (seq-of-pronunciations next-coll)))))