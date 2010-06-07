class Integer

  def factorial
    (1..self).inject(1) { |n,i| n*i }
  end

  def choose(k)
    self.factorial / ( k.factorial * (self-k).factorial )
  end
  
end