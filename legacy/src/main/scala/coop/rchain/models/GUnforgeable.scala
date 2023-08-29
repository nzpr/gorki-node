// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package coop.rchain.models
import coop.rchain.models.BitSetBytesMapper.bitSetBytesMapper
import coop.rchain.models.ParSetTypeMapper.parSetESetTypeMapper
import coop.rchain.models.ParMapTypeMapper.parMapEMapTypeMapper
import coop.rchain.models.BigIntTypeMapper.bigIntBytesTypeMapper

/** Unforgeable names resulting from `new x { ... }`
  * These should only occur as the program is being evaluated. There is no way in
  * the grammar to construct them.
  */
@SerialVersionUID(0L)
final case class GUnforgeable(
    unfInstance: coop.rchain.models.GUnforgeable.UnfInstance = coop.rchain.models.GUnforgeable.UnfInstance.Empty
    ) extends coop.rchain.models.StacksafeMessage[GUnforgeable] with scalapb.lenses.Updatable[GUnforgeable] {
    
    override def equals(x: Any): Boolean = {
    
      import coop.rchain.catscontrib.effect.implicits.sEval
    
     coop.rchain.models.EqualM[coop.rchain.models.GUnforgeable].equals[cats.Eval](this, x).value
    
    }
    
    override def hashCode(): Int = {
    
      import coop.rchain.catscontrib.effect.implicits.sEval
    
     coop.rchain.models.HashM[coop.rchain.models.GUnforgeable].hash[cats.Eval](this).value
    
    }
    
    
    def mergeFromM[F[_]: cats.effect.Sync](`_input__`: _root_.com.google.protobuf.CodedInputStream): F[coop.rchain.models.GUnforgeable] = {
      
      import cats.effect.Sync
      import cats.syntax.all._
      
      Sync[F].defer {
        var __unfInstance = this.unfInstance
        var _done__ = false
        
        Sync[F].whileM_ (Sync[F].delay { !_done__ }) {
          for {
            _tag__ <- Sync[F].delay { _input__.readTag() }
            _ <- _tag__ match {
              case 0 => Sync[F].delay { _done__ = true }
              case 10 =>
                for {
                  readValue       <- coop.rchain.models.SafeParser.readMessage(_input__, unfInstance.gPrivateBody.getOrElse(coop.rchain.models.GPrivate.defaultInstance))
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GPrivateBody(customTypeValue) }
                } yield ()
              case 18 =>
                for {
                  readValue       <- coop.rchain.models.SafeParser.readMessage(_input__, unfInstance.gDeployIdBody.getOrElse(coop.rchain.models.GDeployId.defaultInstance))
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployIdBody(customTypeValue) }
                } yield ()
              case 26 =>
                for {
                  readValue       <- coop.rchain.models.SafeParser.readMessage(_input__, unfInstance.gDeployerIdBody.getOrElse(coop.rchain.models.GDeployerId.defaultInstance))
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployerIdBody(customTypeValue) }
                } yield ()
              case 34 =>
                for {
                  readValue       <- coop.rchain.models.SafeParser.readMessage(_input__, unfInstance.gSysAuthTokenBody.getOrElse(coop.rchain.models.GSysAuthToken.defaultInstance))
                  customTypeValue =  readValue
                  _               <- Sync[F].delay { __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GSysAuthTokenBody(customTypeValue) }
                } yield ()
            case tag => Sync[F].delay { _input__.skipField(tag) }
            }
          } yield ()
        }
        .map { _ => coop.rchain.models.GUnforgeable(
          unfInstance = __unfInstance
        )}
      }
    }
    
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      if (unfInstance.gPrivateBody.isDefined) {
        val __value = unfInstance.gPrivateBody.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (unfInstance.gDeployIdBody.isDefined) {
        val __value = unfInstance.gDeployIdBody.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (unfInstance.gDeployerIdBody.isDefined) {
        val __value = unfInstance.gDeployerIdBody.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      if (unfInstance.gSysAuthTokenBody.isDefined) {
        val __value = unfInstance.gSysAuthTokenBody.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
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
      unfInstance.gPrivateBody.foreach { __v =>
        val __m = __v
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unfInstance.gDeployIdBody.foreach { __v =>
        val __m = __v
        _output__.writeTag(2, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unfInstance.gDeployerIdBody.foreach { __v =>
        val __m = __v
        _output__.writeTag(3, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unfInstance.gSysAuthTokenBody.foreach { __v =>
        val __m = __v
        _output__.writeTag(4, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
    }
    def getGPrivateBody: coop.rchain.models.GPrivate = unfInstance.gPrivateBody.getOrElse(coop.rchain.models.GPrivate.defaultInstance)
    def withGPrivateBody(__v: coop.rchain.models.GPrivate): GUnforgeable = copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GPrivateBody(__v))
    def getGDeployIdBody: coop.rchain.models.GDeployId = unfInstance.gDeployIdBody.getOrElse(coop.rchain.models.GDeployId.defaultInstance)
    def withGDeployIdBody(__v: coop.rchain.models.GDeployId): GUnforgeable = copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployIdBody(__v))
    def getGDeployerIdBody: coop.rchain.models.GDeployerId = unfInstance.gDeployerIdBody.getOrElse(coop.rchain.models.GDeployerId.defaultInstance)
    def withGDeployerIdBody(__v: coop.rchain.models.GDeployerId): GUnforgeable = copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployerIdBody(__v))
    def getGSysAuthTokenBody: coop.rchain.models.GSysAuthToken = unfInstance.gSysAuthTokenBody.getOrElse(coop.rchain.models.GSysAuthToken.defaultInstance)
    def withGSysAuthTokenBody(__v: coop.rchain.models.GSysAuthToken): GUnforgeable = copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GSysAuthTokenBody(__v))
    def clearUnfInstance: GUnforgeable = copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.Empty)
    def withUnfInstance(__v: coop.rchain.models.GUnforgeable.UnfInstance): GUnforgeable = copy(unfInstance = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => unfInstance.gPrivateBody.orNull
        case 2 => unfInstance.gDeployIdBody.orNull
        case 3 => unfInstance.gDeployerIdBody.orNull
        case 4 => unfInstance.gSysAuthTokenBody.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => unfInstance.gPrivateBody.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 2 => unfInstance.gDeployIdBody.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 3 => unfInstance.gDeployerIdBody.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 4 => unfInstance.gSysAuthTokenBody.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: coop.rchain.models.GUnforgeable.type = coop.rchain.models.GUnforgeable
    // @@protoc_insertion_point(GeneratedMessage[GUnforgeable])
}

object GUnforgeable extends scalapb.GeneratedMessageCompanion[coop.rchain.models.GUnforgeable] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[coop.rchain.models.GUnforgeable] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): coop.rchain.models.GUnforgeable = {
    var __unfInstance: coop.rchain.models.GUnforgeable.UnfInstance = coop.rchain.models.GUnforgeable.UnfInstance.Empty
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GPrivateBody(__unfInstance.gPrivateBody.fold(_root_.scalapb.LiteParser.readMessage[coop.rchain.models.GPrivate](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 18 =>
          __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployIdBody(__unfInstance.gDeployIdBody.fold(_root_.scalapb.LiteParser.readMessage[coop.rchain.models.GDeployId](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 26 =>
          __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployerIdBody(__unfInstance.gDeployerIdBody.fold(_root_.scalapb.LiteParser.readMessage[coop.rchain.models.GDeployerId](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case 34 =>
          __unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GSysAuthTokenBody(__unfInstance.gSysAuthTokenBody.fold(_root_.scalapb.LiteParser.readMessage[coop.rchain.models.GSysAuthToken](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
        case tag => _input__.skipField(tag)
      }
    }
    coop.rchain.models.GUnforgeable(
        unfInstance = __unfInstance
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[coop.rchain.models.GUnforgeable] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      coop.rchain.models.GUnforgeable(
        unfInstance = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[coop.rchain.models.GPrivate]]).map(coop.rchain.models.GUnforgeable.UnfInstance.GPrivateBody(_))
            .orElse[coop.rchain.models.GUnforgeable.UnfInstance](__fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[coop.rchain.models.GDeployId]]).map(coop.rchain.models.GUnforgeable.UnfInstance.GDeployIdBody(_)))
            .orElse[coop.rchain.models.GUnforgeable.UnfInstance](__fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).flatMap(_.as[_root_.scala.Option[coop.rchain.models.GDeployerId]]).map(coop.rchain.models.GUnforgeable.UnfInstance.GDeployerIdBody(_)))
            .orElse[coop.rchain.models.GUnforgeable.UnfInstance](__fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).flatMap(_.as[_root_.scala.Option[coop.rchain.models.GSysAuthToken]]).map(coop.rchain.models.GUnforgeable.UnfInstance.GSysAuthTokenBody(_)))
            .getOrElse(coop.rchain.models.GUnforgeable.UnfInstance.Empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = RhoTypesProto.javaDescriptor.getMessageTypes().get(49)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = RhoTypesProto.scalaDescriptor.messages(49)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = coop.rchain.models.GPrivate
      case 2 => __out = coop.rchain.models.GDeployId
      case 3 => __out = coop.rchain.models.GDeployerId
      case 4 => __out = coop.rchain.models.GSysAuthToken
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = coop.rchain.models.GUnforgeable(
    unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.Empty
  )
  sealed trait UnfInstance extends _root_.scalapb.GeneratedOneof {
    def isEmpty: _root_.scala.Boolean = false
    def isDefined: _root_.scala.Boolean = true
    def isGPrivateBody: _root_.scala.Boolean = false
    def isGDeployIdBody: _root_.scala.Boolean = false
    def isGDeployerIdBody: _root_.scala.Boolean = false
    def isGSysAuthTokenBody: _root_.scala.Boolean = false
    def gPrivateBody: _root_.scala.Option[coop.rchain.models.GPrivate] = _root_.scala.None
    def gDeployIdBody: _root_.scala.Option[coop.rchain.models.GDeployId] = _root_.scala.None
    def gDeployerIdBody: _root_.scala.Option[coop.rchain.models.GDeployerId] = _root_.scala.None
    def gSysAuthTokenBody: _root_.scala.Option[coop.rchain.models.GSysAuthToken] = _root_.scala.None
  }
  object UnfInstance {
    @SerialVersionUID(0L)
    case object Empty extends coop.rchain.models.GUnforgeable.UnfInstance {
      type ValueType = _root_.scala.Nothing
      override def isEmpty: _root_.scala.Boolean = true
      override def isDefined: _root_.scala.Boolean = false
      override def number: _root_.scala.Int = 0
      override def value: _root_.scala.Nothing = throw new java.util.NoSuchElementException("Empty.value")
    }
  
    @SerialVersionUID(0L)
    final case class GPrivateBody(value: coop.rchain.models.GPrivate) extends coop.rchain.models.GUnforgeable.UnfInstance {
      type ValueType = coop.rchain.models.GPrivate
      override def isGPrivateBody: _root_.scala.Boolean = true
      override def gPrivateBody: _root_.scala.Option[coop.rchain.models.GPrivate] = Some(value)
      override def number: _root_.scala.Int = 1
    }
    @SerialVersionUID(0L)
    final case class GDeployIdBody(value: coop.rchain.models.GDeployId) extends coop.rchain.models.GUnforgeable.UnfInstance {
      type ValueType = coop.rchain.models.GDeployId
      override def isGDeployIdBody: _root_.scala.Boolean = true
      override def gDeployIdBody: _root_.scala.Option[coop.rchain.models.GDeployId] = Some(value)
      override def number: _root_.scala.Int = 2
    }
    @SerialVersionUID(0L)
    final case class GDeployerIdBody(value: coop.rchain.models.GDeployerId) extends coop.rchain.models.GUnforgeable.UnfInstance {
      type ValueType = coop.rchain.models.GDeployerId
      override def isGDeployerIdBody: _root_.scala.Boolean = true
      override def gDeployerIdBody: _root_.scala.Option[coop.rchain.models.GDeployerId] = Some(value)
      override def number: _root_.scala.Int = 3
    }
    @SerialVersionUID(0L)
    final case class GSysAuthTokenBody(value: coop.rchain.models.GSysAuthToken) extends coop.rchain.models.GUnforgeable.UnfInstance {
      type ValueType = coop.rchain.models.GSysAuthToken
      override def isGSysAuthTokenBody: _root_.scala.Boolean = true
      override def gSysAuthTokenBody: _root_.scala.Option[coop.rchain.models.GSysAuthToken] = Some(value)
      override def number: _root_.scala.Int = 4
    }
  }
  implicit class GUnforgeableLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.GUnforgeable]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, coop.rchain.models.GUnforgeable](_l) {
    def gPrivateBody: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.GPrivate] = field(_.getGPrivateBody)((c_, f_) => c_.copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GPrivateBody(f_)))
    def gDeployIdBody: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.GDeployId] = field(_.getGDeployIdBody)((c_, f_) => c_.copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployIdBody(f_)))
    def gDeployerIdBody: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.GDeployerId] = field(_.getGDeployerIdBody)((c_, f_) => c_.copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GDeployerIdBody(f_)))
    def gSysAuthTokenBody: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.GSysAuthToken] = field(_.getGSysAuthTokenBody)((c_, f_) => c_.copy(unfInstance = coop.rchain.models.GUnforgeable.UnfInstance.GSysAuthTokenBody(f_)))
    def unfInstance: _root_.scalapb.lenses.Lens[UpperPB, coop.rchain.models.GUnforgeable.UnfInstance] = field(_.unfInstance)((c_, f_) => c_.copy(unfInstance = f_))
  }
  final val G_PRIVATE_BODY_FIELD_NUMBER = 1
  final val G_DEPLOY_ID_BODY_FIELD_NUMBER = 2
  final val G_DEPLOYER_ID_BODY_FIELD_NUMBER = 3
  final val G_SYS_AUTH_TOKEN_BODY_FIELD_NUMBER = 4
  def of(
    unfInstance: coop.rchain.models.GUnforgeable.UnfInstance
  ): _root_.coop.rchain.models.GUnforgeable = _root_.coop.rchain.models.GUnforgeable(
    unfInstance
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[GUnforgeable])
}
