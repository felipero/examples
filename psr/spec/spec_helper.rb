begin
  # Just in case the bundle was locked
  # This shouldn't happen in a dev environment but lets be safe
  require File.expand_path('../../.bundle/environment', __FILE__)
rescue LoadError
  require 'rubygems'
  require 'bundler'
  Bundler.setup
end
Bundler.require(:default, :test)

lib = File.expand_path('../../lib', __FILE__)
$LOAD_PATH.unshift(lib) if File.directory?(lib)

require 'psr'
require 'primes'

