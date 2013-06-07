(fn [coll]
  (let [binary-str (map #(Integer/toBinaryString %) coll)
        board (mapv #(vec (concat (repeat (- (apply max (map count binary-str)) (count %)) \0) %)) binary-str)]
    (letfn [(count-one [s e g]
              (let [points (if (zero? (first g))
                             (map #(vec [(first s) %]) (range (second s) (inc (second e))))
                             (map #(vec [% (second s)]) (range (first s) (inc (first e)))))]
                (if (every? #(= % \1) (map #(get-in board %) points))
                  (count points)
                  0)))
            (step [s e m n g r]
              (let [one-count (count-one s e g)]
                (if (zero? one-count)
                  r
                  (step (map #(+ %1 %2) s m) (map #(+ %1 %2) e n) m n g (+ r one-count)))))]
      (let [result (apply max
                     (mapcat
                       #(map
                          (fn [m n g] (step % % m n g 0))
                          [[-1 -1] [-1 0] [-1 -1] [-1 1] [0 1] [-1 1] [1 -1] [1 0] [1 -1] [-1 -1] [0 -1] [-1 -1]]
                          [[-1 0] [-1 1] [-1 1] [0 1] [1 1] [1 1] [1 0] [1 1] [1 1] [0 -1] [1 -1] [1 -1]]
                          [[0 1] [0 1] [0 1] [1 0] [1 0] [1 0] [0 1] [0 1] [0 1] [1 0] [1 0] [1 0]])
                       (filter
                         #(= \1 (get-in board %))
                         (mapcat #(map (fn [x] [x %]) (range 0 (count board))) (range 0 (count board))))))]
        (if (= 1 result)
          nil
          result)))))
