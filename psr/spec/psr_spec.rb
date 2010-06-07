require 'spec_helper'

describe PSR do

  it "should find the right answer" do
    PSR.answer_for(190).should == 1096883702440585
  end

end