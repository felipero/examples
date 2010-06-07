require 'primes'

class PSR
  def self.for(n = 190)
    ps = Primes.for(n)
    fh =[1]
    hop = (ps.length/2).to_i
    ps[0..hop].each do |prime|
      fh += fh.map {|value| value * prime }
    end
    sh =[1]
    ps[hop + 1..ps.length].each do |prime|
      sh += sh.map {|value| value * prime }
    end

    fh = fh.sort
    sh = sh.sort.reverse

    sqrt_i = (fh[-1] * sh[0])**0.5
    l1, l2 = fh.length, sh.length

    i = j = psr = 0
    while (i < l1 and j < l2)
      current = fh[i] * sh[j]
      if current > sqrt_i
        j += 1
      elsif current < sqrt_i
         psr = current if current > psr
         i += 1
      end
    end
    return psr
  end

  def self.answer_for(n = 190)
    return self.for(n) % (10**16)
  end
end