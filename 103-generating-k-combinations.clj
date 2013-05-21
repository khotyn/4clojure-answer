(fn [k s]
  (set (filter #(= k (count %)) (reduce #(concat %1 (map (fn [i] (set (conj i %2))) %1)) #{#{}} s))))