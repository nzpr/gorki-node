// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package coop.rchain.models
import coop.rchain.models.BitSetBytesMapper.bitSetBytesMapper
import coop.rchain.models.ParSetTypeMapper.parSetESetTypeMapper
import coop.rchain.models.ParMapTypeMapper.parMapEMapTypeMapper
import coop.rchain.models.BigIntTypeMapper.bigIntBytesTypeMapper

/** *
  * Either rholang code or code built in to the interpreter.
  */
@SerialVersionUID(0L)
final case class TaggedContinuation(
    taggedCont: coop.rchain.models.TaggedContinuation.TaggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.Empty
    ) extends coop.rchain.models.StacksafeMessage[TaggedContinuation] with scalapb.lenses.Updatable[TaggedContinuation] {
    
    override def equals(x: Any): Boolean = {
    
      import coop.rchain.catscontrib.effect.implicits.sEval
    
     coop.rchain.models.EqualM[coop.rchain.models.TaggedContinuation].equals[cats.Eval](this, x).value
    
    }
    
    override def hashCode(): Int = {
    
      import coop.rchain.catscontrib.effect.implicits.sEval
    
     coop.rchain.models.HashM[coop.rchain.models.TaggedContinuation].hash[cats.Eval](this).value
    
    }
    
    
    def mergeFromM[F[_]: cats.effect.Sync](`_input__`: _root_.com.google.protobuf.CodedInputStream): F[coop.rchain.models.TaggedContinuation] = {
      
      import cats.effect.Sync
      import cats.syntax.all._
      
      Sync[F].defer {
        var __taggedCont = this.taggedCont
        var _done__ = false
        
        Sync[F].whileM_ (Sync[F].delay { !_done__ }) {
          for {
            _tag__ <- Sync[F].delay { _input__.readTag() }
            _ <- _tag__ match {
              case 0 => Sync[F].delay { _done__ = true }
              case 10 =>
                for {
                  readValue       <- coop.rchain.models.SafeParser.readMessage(_input__, taggedCont.parBody.getOrElse(coop.rchain.models.ParWithRandom.defaultInstance))
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ParBody(customTypeValue) }
                } yield ()
              case 16 =>
                for {
                  readValue       <- Sync[F].delay { _input__.readInt64() }
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ScalaBodyRef(customTypeValue) }
                } yield ()
            case tag => Sync[F].delay { _input__.skipField(tag) }
            }
          } yield ()
        }
        .map { _ => coop.rchain.models.TaggedContinuation(
          taggedCont = __taggedCont
        )}
      }
    }
    
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      if (taggedCont.parBody.isDefined) {
        val __value = taggedCont.parBody.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (taggedCont.scalaBodyRef.isDefined) {
        val __value = taggedCont.scalaBodyRef.get
        __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(2, __value)
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
      taggedCont.parBody.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      taggedCont.scalaBodyRef.foreach { __v =>
        val __m = __v
        _output__.writeInt64(2, __m)
      };
    }
    def getParBody: coop.rchain.models.ParWithRandom = taggedCont.parBody.getOrElse(coop.rchain.models.ParWithRandom.defaultInstance)
    def withParBody(__v: coop.rchain.models.ParWithRandom): TaggedContinuation = copy(taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ParBody(__v))
    def getScalaBodyRef: _root_.scala.Long = taggedCont.scalaBodyRef.getOrElse(0L)
    def withScalaBodyRef(__v: _root_.scala.Long): TaggedContinuation = copy(taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ScalaBodyRef(__v))
    def clearTaggedCont: TaggedContinuation = copy(taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.Empty)
    def withTaggedCont(__v: coop.rchain.models.TaggedContinuation.TaggedCont): TaggedContinuation = copy(taggedCont = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => taggedCont.parBody.orNull
        case 2 => taggedCont.scalaBodyRef.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => taggedCont.parBody.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => taggedCont.scalaBodyRef.map(_root_.scalapb.descriptors.PLong(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: coop.rchain.models.TaggedContinuation.type = coop.rchain.models.TaggedContinuation
    // @@protoc_insertion_point(GeneratedMessage[TaggedContinuation])
}

object TaggedContinuation extends scalapb.GeneratedMessageCompanion[coop.rchain.models.TaggedContinuation] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[coop.rchain.models.TaggedContinuation] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): coop.rchain.models.TaggedContinuation = {
    var __taggedCont: coop.rchain.models.TaggedContinuation.TaggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.Empty
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ParBody(__taggedCont.parBody.fold(_root_.scalapb.LiteParser.readMessage[coop.rchain.models.ParWithRandom](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 16 =>
          __taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ScalaBodyRef(_input__.readInt64())
        case tag => _input__.skipField(tag)
      }
    }
    coop.rchain.models.TaggedContinuation(
        taggedCont = __taggedCont
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[coop.rchain.models.TaggedContinuation] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      coop.rchain.models.TaggedContinuation(
        taggedCont = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[coop.rchain.models.ParWithRandom]]).map(coop.rchain.models.TaggedContinuation.TaggedCont.ParBody(_))
            .orElse[coop.rchain.models.TaggedContinuation.TaggedCont](__fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[_root_.scala.Long]]).map(coop.rchain.models.TaggedContinuation.TaggedCont.ScalaBodyRef(_)))
            .getOrElse(coop.rchain.models.TaggedContinuation.TaggedCont.Empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = RhoTypesProto.javaDescriptor.getMessageTypes().get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = RhoTypesProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = coop.rchain.models.ParWithRandom
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = coop.rchain.models.TaggedContinuation(
    taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.Empty
  )
  sealed trait TaggedCont extends _root_.scalapb.GeneratedOneof {
    def isEmpty: _root_.scala.Boolean = false
    def isDefined: _root_.scala.Boolean = true
    def isParBody: _root_.scala.Boolean = false
    def isScalaBodyRef: _root_.scala.Boolean = false
    def parBody: _root_.scala.Option[coop.rchain.models.ParWithRandom] = _root_.scala.None
    def scalaBodyRef: _root_.scala.Option[_root_.scala.Long] = _root_.scala.None
  }
  object TaggedCont {
    @SerialVersionUID(0L)
    case object Empty extends coop.rchain.models.TaggedContinuation.TaggedCont {
      type ValueType = _root_.scala.Nothing
      override def isEmpty: _root_.scala.Boolean = true
      override def isDefined: _root_.scala.Boolean = false
      override def number: _root_.scala.Int = 0
      override def value: _root_.scala.Nothing = throw new java.util.NoSuchElementException("Empty.value")
    }
  
    @SerialVersionUID(0L)
    final case class ParBody(value: coop.rchain.models.ParWithRandom) extends coop.rchain.models.TaggedContinuation.TaggedCont {
      type ValueType = coop.rchain.models.ParWithRandom
      override def isParBody: _root_.scala.Boolean = true
      override def parBody: _root_.scala.Option[coop.rchain.models.ParWithRandom] = Some(value)
      override def number: _root_.scala.Int = 1
    }
    @SerialVersionUID(0L)
    final case class ScalaBodyRef(value: _root_.scala.Long) extends coop.rchain.models.TaggedContinuation.TaggedCont {
      type ValueType = _root_.scala.Long
      override def isScalaBodyRef: _root_.scala.Boolean = true
      override def scalaBodyRef: _root_.scala.Option[_root_.scala.Long] = Some(value)
      override def number: _root_.scala.Int = 2
    }
  }
  implicit class TaggedContinuationLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.TaggedContinuation]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, coop.rchain.models.TaggedContinuation](_l) {
    def parBody: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.ParWithRandom] = field(_.getParBody)((c_, f_) => c_.copy(taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ParBody(f_)))
    def scalaBodyRef: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.getScalaBodyRef)((c_, f_) => c_.copy(taggedCont = coop.rchain.models.TaggedContinuation.TaggedCont.ScalaBodyRef(f_)))
    def taggedCont: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.TaggedContinuation.TaggedCont] = field(_.taggedCont)((c_, f_) => c_.copy(taggedCont = f_))
  }
  final val PAR_BODY_FIELD_NUMBER = 1
  final val SCALA_BODY_REF_FIELD_NUMBER = 2
  def of(
    taggedCont: coop.rchain.models.TaggedContinuation.TaggedCont
  ): _root_.coop.rchain.models.TaggedContinuation = _root_.coop.rchain.models.TaggedContinuation(
    taggedCont
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[TaggedContinuation])
}
