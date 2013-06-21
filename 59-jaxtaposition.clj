(fn [& funcs]
  (fn [& args]
    (map #(apply % args) funcs)))