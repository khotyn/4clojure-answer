(fn [& funcs]
  (fn [& args]
    (reduce #(%2 %1) (apply (last funcs) args) (rest (reverse funcs)))))