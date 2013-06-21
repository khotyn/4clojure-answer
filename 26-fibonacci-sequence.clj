#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))
