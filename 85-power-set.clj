(fn [s]
  (set (reduce #(concat %1 (map (fn [i] (set (conj i %2))) %1)) #{#{}} s)))