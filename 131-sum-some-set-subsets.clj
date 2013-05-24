(fn [& sets]
  (not=
    nil
    (seq
      (reduce
        #(set (filter (fn [ele] (%1 ele)) %2))
        (map
          (fn [s]
            (set
              (map
                #(reduce + %)
                (filter
                  #(seq %)
                  (reduce #(concat %1 (map (fn [i] (set (conj i %2))) %1)) #{#{}} s)))))
          sets)))))