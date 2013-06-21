(fn [f x y]
      (if (f x y) :lt (if (f y x) :gt :eq)))
