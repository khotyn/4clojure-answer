(fn
  [a b]
  (let [ret (find b a)]
    (and (not (= ret nil)) (= (get b a) nil))))
