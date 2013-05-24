(fn [trump]
  (fn [trick]
    (let [lead-suit (if trump trump (:suit (first trick)))]
      (last (sort-by :rank (filter #(= lead-suit (:suit %)) trick))))))