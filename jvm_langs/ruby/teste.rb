require 'arduino'

@cores = Array.new
@cores << green_led
@cores << blue_led
@cores << yellow_led
@cores << red_led

def gera_sequencia(quantidade)
  @sequencia = []

  quantidade.times do
    @sequencia << @cores[rand * @cores.size]
  end
  
  @sequencia
end

def imprime_sequencia(sequencia)
  
  sequencia.each do |cor|
    turn_led_on(cor)
    turn_led_off(cor)
  end
  
end

qtd = 4

sequencia_inicial = gera_sequencia(qtd)

open_writing()

imprime_sequencia(sequencia_inicial)

done()

start_reading()

btn = []

qtd.times do
  
  while b == nil do
    b << read_button()
  end
  
  btn << b
  puts "Botao '#{b}' pressionado"

end

done()

if btn == sequencia_inicial
  puts "CERTO!"
end

done()

close_arduino()

