(fn [num]
  (letfn [(square-sum-of-digits [num]
            (reduce + (map #(* % %) (map #(Integer/parseInt (str %)) (.toString num)))))
          (step [num mid-results]
            (let [mid-result (square-sum-of-digits num)]
              (if (= 1 mid-result)
                true
                (if (some #{mid-result} mid-results)
                  false
                  (step mid-result (cons mid-result mid-results))))))]
    (step num [num])))