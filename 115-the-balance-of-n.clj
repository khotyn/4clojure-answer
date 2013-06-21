(fn [num]
  (letfn [(str-sum [s]
            (apply + (map #(Integer/parseInt (.toString %)) s)))]
    (let [num-s (.toString num) len (quot (count num-s) 2)]
      (= (str-sum (take len num-s)) (str-sum (take-last len num-s))))))
