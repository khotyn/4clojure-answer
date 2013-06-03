(fn []
  (let [s ["(fn [] "
           "(let [s "
           "]"
           " (apply str (concat (take 2 s) [s] (drop 2 s)))))"]]
    (apply str (concat (take 2 s) [s] (drop 2 s)))))
