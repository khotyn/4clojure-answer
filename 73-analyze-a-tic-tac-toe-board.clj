(fn [board]
  (letfn [(check-horizonal [board]
            (first (flatten (filter #(every? #{:x :o } %) (filter #(= 1 (count (set %))) board)))))]
    (let [h (check-horizonal board)]
      (if
        h
        h
        (let [v (check-horizonal (apply (partial map #(vec [%1 %2 %3])) board))]
          (if
            v
            v
            (let [fd (check-horizonal [[(first (first board)) (second (second board)) (last (last board))]])]
              (if
                fd
                fd
                (check-horizonal [[(last (first board)) (second (second board)) (first (last board))]])))))))))