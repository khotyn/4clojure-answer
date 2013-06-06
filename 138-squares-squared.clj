(fn [i j]
  (let [num-str (apply str (take-while #(<= % j) (iterate #(* % %) i)))
        str-size (first (drop-while #(< (* % %) (count num-str)) (range)))
        s (concat num-str (repeat (- (* str-size str-size) (count num-str)) \*))
        board-size (dec (* 2 str-size))
        init-board (vec (repeat board-size (vec (repeat board-size \space))))]
    (println init-board)
    (letfn [(step [board current gap str-seq]
              (if (seq str-seq)
                (let [next-board (assoc-in board current (first str-seq))
                      f-next-gap (if (zero? (first current))
                                   [1 -1]
                                   (if (= (dec board-size) (first current))
                                     [-1 1]
                                     (if (zero? (second current))
                                       [1 1]
                                       (if (= (dec board-size) (second current))
                                         [-1 -1]
                                         gap))))
                      f-next-current (map #(+ %1 %2) current f-next-gap)
                      next-gap (if (= \space (get-in board f-next-current))
                                 f-next-gap
                                 (case f-next-gap
                                   [1 -1] [1 1]
                                   [1 1] [-1 1]
                                   [-1 1] [-1 -1]
                                   [-1 -1] [1 -1]))]
                  (step next-board (map #(+ %1 %2) current next-gap) next-gap (next str-seq)))
                board))]
      (mapv #(apply str %) (step init-board (if (odd? str-size) [(dec str-size) (dec board-size)] [(dec str-size) 0]) [1 1] (reverse s))))))
