(fn [n a b]
  (letfn [(ya-sum [num]
            (if (even? num) (* (inc num) (quot num 2)) (* num (quot (inc num) 2N))))]
    (-
      (+
        (* a (ya-sum (quot (dec n) a)))
        (* b (ya-sum (quot (dec n) b))))
      (* (* a b) (ya-sum (quot (dec n) (* a b)))))))
