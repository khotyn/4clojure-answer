(fn [board]
  (let [vec-board (vec (map vec board))
        row-count (count vec-board)
        column-count (count (first vec-board))]
    (letfn [(get-pos [ch]
              (mapcat #(mapcat (fn [j] (if (= ch ((vec-board %) j)) [% j])) (range 0 column-count)) (range 0 row-count)))
            (continous-blank [ch coordinate searched-point])
            (step [[results searched-point] [x y]]
              (let [neighbours (concat
                                 (if (pos? x) [[(dec x) y]])
                                 (if (pos? y) [[x (dec y)]])
                                 (if (> (- row-count x) 1) [[(inc x) y]])
                                 (if (> (- column-count y) 1) [[x (inc y)]]))
                    valid-neighbours (filter
                                       #(and
                                          (not= ((vec-board (first %)) (last %)) \#)
                                          (nil? (some #{%} searched-point)))
                                       neighbours)]
                (if (seq valid-neighbours)
                  (if (some #(= ((vec-board (first %)) (last %)) \C) valid-neighbours)
                    [(cons true results) (conj searched-point [x y])]
                    (reduce #(step %1 %2) [results (conj searched-point [x y])] valid-neighbours))
                  [results (conj searched-point [x y])])))]
      (let [mouse (get-pos \M)]
        ((complement empty?) (first (step [[] #{(vec mouse)}] mouse)))))))