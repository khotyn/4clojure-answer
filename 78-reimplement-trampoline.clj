(fn my-trampoline [f & params]
  (let [mid-result (apply f params)]
    (if (fn? mid-result)
      (apply my-trampoline mid-result [])
      mid-result)))