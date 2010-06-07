require "spec_helper"

describe Primes do
  it "should find primes for a number" do
    Primes.for(15).should == [2,3,5,7,11,13]
  end
end