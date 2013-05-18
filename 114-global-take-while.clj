(fn global-take-while [n f coll]
  (let [first-ele (first coll)]
    (if (f first-ele)
      (if (> n 1)
        (cons first-ele (global-take-while (dec n) f (rest coll))))
      (cons first-ele (global-take-while n f (rest coll))))))