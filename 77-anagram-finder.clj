(fn [coll]
  (set (map #(set (val %)) (filter #(> (count (val %)) 1) (group-by sort coll)))))
