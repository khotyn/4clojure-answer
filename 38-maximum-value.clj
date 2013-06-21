(fn [& more]
  (reduce
    (fn
      [x y]
      (if (< x y) y x)
      )
    more
    )
  )
