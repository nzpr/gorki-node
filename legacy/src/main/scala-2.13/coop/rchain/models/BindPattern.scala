// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package coop.rchain.models
import coop.rchain.models.EqualMImplicits.*
import coop.rchain.models.HashMImplicits.*

@SerialVersionUID(0L)
final case class BindPattern(
    patterns: _root_.scala.Seq[coop.rchain.models.Par] = _root_.scala.Seq.empty,
    remainder: _root_.scala.Option[coop.rchain.models.Var] = _root_.scala.None,
    freeCount: _root_.scala.Int = 0
    ) extends coop.rchain.models.StacksafeMessage[BindPattern] with scalapb.lenses.Updatable[BindPattern] {
    
    override def equals(x: Any): Boolean = {
    
      import coop.rchain.catscontrib.effect.implicits.sEval
    
     coop.rchain.models.EqualM[coop.rchain.models.BindPattern].equals[cats.Eval](this, x).value
    
    }
    
    override def hashCode(): Int = {
    
      import coop.rchain.catscontrib.effect.implicits.sEval
    
     coop.rchain.models.HashM[coop.rchain.models.BindPattern].hash[cats.Eval](this).value
    
    }
    
    
    def mergeFromM[F[_]: cats.effect.Sync](`_input__`: _root_.com.google.protobuf.CodedInputStream): F[coop.rchain.models.BindPattern] = {
      
      import cats.effect.Sync
      import cats.syntax.all.*
      
      Sync[F].defer {
        val __patterns = (new _root_.scala.collection.immutable.VectorBuilder[coop.rchain.models.Par] ++= this.patterns)
        var __remainder = this.remainder
        var __freeCount = this.freeCount
        var _done__ = false
        
        Sync[F].whileM_ (Sync[F].delay { !_done__ }) {
          for {
            _tag__ <- Sync[F].delay { _input__.readTag() }
            _ <- _tag__ match {
              case 0 => Sync[F].delay { _done__ = true }
              case 10 =>
                for {
                  readValue       <- coop.rchain.models.SafeParser.readMessage(_input__, coop.rchain.models.Par.defaultInstance)
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __patterns += customTypeValue }
                } yield ()
              case 18 =>
                for {
                  readValue       <- coop.rchain.models.SafeParser.readMessage(_input__, __remainder.getOrElse(coop.rchain.models.Var.defaultInstance))
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __remainder = Option(customTypeValue) }
                } yield ()
              case 24 =>
                for {
                  readValue       <- Sync[F].delay { _input__.readInt32() }
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __freeCount = customTypeValue }
                } yield ()
            case tag => Sync[F].delay { _input__.skipField(tag) }
            }
          } yield ()
        }
        .map { _ => coop.rchain.models.BindPattern(
          patterns = __patterns.result(),
          remainder = __remainder,
          freeCount = __freeCount
        )}
      }
    }
    
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      patterns.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      if (remainder.isDefined) {
        val __value = remainder.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      
      {
        val __value = freeCount
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(3, __value)
        }
      };
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var __size = __serializedSizeMemoized
      if (__size == 0) {
        __size = __computeSerializedSize() + 1
        __serializedSizeMemoized = __size
      }
      __size - 1
      
    }
    
    @transient var _serializedSizeM: coop.rchain.models.Memo[Int] = null
    
    def serializedSizeM: coop.rchain.models.Memo[Int] = synchronized {
      if(_serializedSizeM == null) {
        _serializedSizeM = new coop.rchain.models.Memo(coop.rchain.models.ProtoM.serializedSize(this))
        _serializedSizeM
      } else _serializedSizeM
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      patterns.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      remainder.foreach { __v =>
        val __m = __v
        _output__.writeTag(2, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      {
        val __v = freeCount
        if (__v != 0) {
          _output__.writeInt32(3, __v)
        }
      };
    }
    def clearPatterns = copy(patterns = _root_.scala.Seq.empty)
    def addPatterns(__vs: coop.rchain.models.Par *): BindPattern = addAllPatterns(__vs)
    def addAllPatterns(__vs: Iterable[coop.rchain.models.Par]): BindPattern = copy(patterns = patterns ++ __vs)
    def withPatterns(__v: _root_.scala.Seq[coop.rchain.models.Par]): BindPattern = copy(patterns = __v)
    def getRemainder: coop.rchain.models.Var = remainder.getOrElse(coop.rchain.models.Var.defaultInstance)
    def clearRemainder: BindPattern = copy(remainder = _root_.scala.None)
    def withRemainder(__v: coop.rchain.models.Var): BindPattern = copy(remainder = Option(__v))
    def withFreeCount(__v: _root_.scala.Int): BindPattern = copy(freeCount = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => patterns
        case 2 => remainder.orNull
        case 3 => {
          val __t = freeCount
          if (__t != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PRepeated(patterns.iterator.map(_.toPMessage).toVector)
        case 2 => remainder.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 3 => _root_.scalapb.descriptors.PInt(freeCount)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: coop.rchain.models.BindPattern.type = coop.rchain.models.BindPattern
    // @@protoc_insertion_point(GeneratedMessage[BindPattern])
}

object BindPattern extends scalapb.GeneratedMessageCompanion[coop.rchain.models.BindPattern] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[coop.rchain.models.BindPattern] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): coop.rchain.models.BindPattern = {
    val __patterns: _root_.scala.collection.immutable.VectorBuilder[coop.rchain.models.Par] = new _root_.scala.collection.immutable.VectorBuilder[coop.rchain.models.Par]
    var __remainder: _root_.scala.Option[coop.rchain.models.Var] = _root_.scala.None
    var __freeCount: _root_.scala.Int = 0
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __patterns += _root_.scalapb.LiteParser.readMessage[coop.rchain.models.Par](_input__)
        case 18 =>
          __remainder = Option(__remainder.fold(_root_.scalapb.LiteParser.readMessage[coop.rchain.models.Var](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 24 =>
          __freeCount = _input__.readInt32()
        case tag => _input__.skipField(tag)
      }
    }
    coop.rchain.models.BindPattern(
        patterns = __patterns.result(),
        remainder = __remainder,
        freeCount = __freeCount
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[coop.rchain.models.BindPattern] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      coop.rchain.models.BindPattern(
        patterns = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Seq[coop.rchain.models.Par]]).getOrElse(_root_.scala.Seq.empty),
        remainder = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[coop.rchain.models.Var]]),
        freeCount = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Int]).getOrElse(0)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = RhoTypesProto.javaDescriptor.getMessageTypes().get(9)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = RhoTypesProto.scalaDescriptor.messages(9)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = coop.rchain.models.Par
      case 2 => __out = coop.rchain.models.Var
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = coop.rchain.models.BindPattern(
    patterns = _root_.scala.Seq.empty,
    remainder = _root_.scala.None,
    freeCount = 0
  )
  implicit class BindPatternLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.BindPattern]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, coop.rchain.models.BindPattern](_l) {
    def patterns: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[coop.rchain.models.Par]] = field(_.patterns)((c_, f_) => c_.copy(patterns = f_))
    def remainder: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.Var] = field(_.getRemainder)((c_, f_) => c_.copy(remainder = Option(f_)))
    def optionalRemainder: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[coop.rchain.models.Var]] = field(_.remainder)((c_, f_) => c_.copy(remainder = f_))
    def freeCount: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.freeCount)((c_, f_) => c_.copy(freeCount = f_))
  }
  final val PATTERNS_FIELD_NUMBER = 1
  final val REMAINDER_FIELD_NUMBER = 2
  final val FREECOUNT_FIELD_NUMBER = 3
  def of(
    patterns: _root_.scala.Seq[coop.rchain.models.Par],
    remainder: _root_.scala.Option[coop.rchain.models.Var],
    freeCount: _root_.scala.Int
  ): _root_.coop.rchain.models.BindPattern = _root_.coop.rchain.models.BindPattern(
    patterns,
    remainder,
    freeCount
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[BindPattern])
}
