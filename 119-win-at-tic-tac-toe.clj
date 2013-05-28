(fn [piece board]
  (letfn [(step [board]
            (filter (complement nil?) (map
                                        (fn [index]
                                          (let [line (board index)]
                                            (if (and
                                                  (= 2 (count (filter #(= % piece) line)))
                                                  (= 1 (count (filter #(= % :e ) line))))
                                              (first (filter (complement nil?) (map
                                                                                 (fn [jndex]
                                                                                   (if (= :e (line jndex))
                                                                                     [index jndex]))
                                                                                 (range 0 (count line))))))))
                                        (range 0 (count board)))))]
    (set (concat
           (step board)
           (map #(vec (reverse %)) (step (vec (apply (partial map #(vec [%1 %2 %3])) board))))
           (let [line [(first (first board)) (second (second board)) (last (last board))]]
             (if (and
                   (= 2 (count (filter #(= % piece) line)))
                   (= 1 (count (filter #(= % :e ) line))))
               (if (= :e (first line))
                 [[0 0]]
                 (if (= :e (second line))
                   [[1 1]]
                   (if (= :e (last line))
                     [[2 2]])))
               []))
           (let [line [(last (first board)) (second (second board)) (first (last board))]]
             (if (and
                   (= 2 (count (filter #(= % piece) line)))
                   (= 1 (count (filter #(= % :e ) line))))
               (if (= :e (first line))
                 [[0 2]]
                 (if (= :e (second line))
                   [[1 1]]
                   (if (= :e (last line))
                     [[2 0]])))
               []))))))