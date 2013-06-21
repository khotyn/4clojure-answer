(defn palindromic-num [num]
  (letfn [(reverse-digit [num result]
            (if
              (zero? (quot num 10))
              (+ (mod num 10) (* result 10))
              (reverse-digit (quot num 10) (+ (mod num 10) (* result 10)))))
          (palindromic-in-i-digit [low up]
            (lazy-cat
              (lazy-cat
                (map #(if (< % 10) % (reverse-digit (quot % 10) %)) (range low up))
                (drop-while
                  zero?
                  (map #(reverse-digit % %) (range low up))))
              (palindromic-in-i-digit up (* up 10))))]
    (filter #(>= % num) (let [len (count (.toString num))
                              digit (quot len 2)
                              low (quot num (apply * (repeat digit 10N)))
                              up (apply * (repeat (count (.toString low)) 10N))]
                          (palindromic-in-i-digit low up)))))
