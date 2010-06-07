require 'mathn'

class Primes
  def self.for(n = 1)
    2.upto(n).select {|g| Prime::instance.prime? g }
  end
end