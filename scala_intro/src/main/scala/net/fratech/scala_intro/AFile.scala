package net.fratech {

  package scala_intro {
    import forJava.Phase
    import scala_intro.model.Module

    class Project  {
      var phase: Module = new Phase

      def start(m: Module) = {
        phase = m
      }
    }

    package model {

      trait Module

    }

    package forJava {
      import scala_intro.model.Module

      class Phase extends Module

    }

  }

}