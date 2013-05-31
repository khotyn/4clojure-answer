(fn [word board]
  (letfn [(check-valid [word line]
            (if (some #{\#} line)
              (true? (some true? (map #(check-valid word %) (re-seq #"[^#]*" (apply str line)))))
              (if (= (count word) (count line))
                (if (and (seq word) (seq line))
                  (if (or (= \_ (first line)) (= (first word) (first line)))
                    (check-valid (next word) (next line))
                    false)
                  true)
                false)))]
    (let [non-space-board (map #(filter (fn [ch] (not= \space ch)) %) board)]
      (true? (some true? (mapcat
                           (fn [ch]
                             (map
                               #(check-valid word %)
                               (filter
                                 #(or (some #{ch} %) (every? #{\# \_} %))
                                 (concat non-space-board (apply (partial map (fn [& coll] coll)) non-space-board)))))
                           word))))))