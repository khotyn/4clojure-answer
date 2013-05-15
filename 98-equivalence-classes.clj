(fn [f s]
  (set (map #(set (val %)) (group-by f s))))