(fn [coll]
  (let [seqs (reverse (map #(concat (first %) (map (fn [i] (last i)) (rest %)))
                        (filter #(every? (fn [ele] (< (first ele) (last ele))) %)
                          (partition-by
                            #(< (first %) (last %))
                            (partition 2 1 coll)))))]
    (if (empty? seqs)
      []
      (apply (partial max-key count) seqs))))