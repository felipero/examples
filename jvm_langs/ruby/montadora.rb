module Montadora
  
  def release_model(model, year = 2010)
    if @models[year] then @models[year] << model else @models[year] = [model] end
  end
  
end


class GM
  include Montadora

  attr_accessor :models
  
  def initialize()
    puts "INITIALIZE"
    @models = {1989 => ['chevette', 'opala', 'monza'], 2007 => ['celta', 'astra', 'corsa'], 2008 => ['celta', 'astra', 'corsa']}
  end
  
end

gm = GM.new

puts gm.models

gm.release_models('Vectra GT')
gm.release_models('Vectra GT', 2009)
gm.release_models('Astra')

puts gm.models
