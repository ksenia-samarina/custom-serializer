package benchmarks.proto;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: person.proto
// Protobuf Java Version: 4.28.2

public final class PersonProtoClass {
  private PersonProtoClass() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
            com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
            /* major= */ 4,
            /* minor= */ 28,
            /* patch= */ 2,
            /* suffix= */ "",
            PersonProtoClass.class.getName());
  }
  public static void registerAllExtensions(
          com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
          com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
            (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PersonOrBuilder extends
          // @@protoc_insertion_point(interface_extends:Person)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 id = 1;</code>
     * @return The id.
     */
    int getId();

    /**
     * <code>bool sex = 2;</code>
     * @return The sex.
     */
    boolean getSex();

    /**
     * <code>int64 phoneNumber = 3;</code>
     * @return The phoneNumber.
     */
    long getPhoneNumber();

    /**
     * <code>string email = 4;</code>
     * @return The email.
     */
    java.lang.String getEmail();
    /**
     * <code>string email = 4;</code>
     * @return The bytes for email.
     */
    com.google.protobuf.ByteString
    getEmailBytes();

    /**
     * <code>repeated string nameSurname = 5;</code>
     * @return A list containing the nameSurname.
     */
    java.util.List<java.lang.String>
    getNameSurnameList();
    /**
     * <code>repeated string nameSurname = 5;</code>
     * @return The count of nameSurname.
     */
    int getNameSurnameCount();
    /**
     * <code>repeated string nameSurname = 5;</code>
     * @param index The index of the element to return.
     * @return The nameSurname at the given index.
     */
    java.lang.String getNameSurname(int index);
    /**
     * <code>repeated string nameSurname = 5;</code>
     * @param index The index of the value to return.
     * @return The bytes of the nameSurname at the given index.
     */
    com.google.protobuf.ByteString
    getNameSurnameBytes(int index);
  }
  /**
   * Protobuf type {@code Person}
   */
  public static final class Person extends
          com.google.protobuf.GeneratedMessage implements
          // @@protoc_insertion_point(message_implements:Person)
          PersonOrBuilder {
    private static final long serialVersionUID = 0L;
    static {
      com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
              com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
              /* major= */ 4,
              /* minor= */ 28,
              /* patch= */ 2,
              /* suffix= */ "",
              Person.class.getName());
    }
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private Person() {
      email_ = "";
      nameSurname_ =
              com.google.protobuf.LazyStringArrayList.emptyList();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return PersonProtoClass.internal_static_Person_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return PersonProtoClass.internal_static_Person_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      PersonProtoClass.Person.class, PersonProtoClass.Person.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private int id_ = 0;
    /**
     * <code>int32 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }

    public static final int SEX_FIELD_NUMBER = 2;
    private boolean sex_ = false;
    /**
     * <code>bool sex = 2;</code>
     * @return The sex.
     */
    @java.lang.Override
    public boolean getSex() {
      return sex_;
    }

    public static final int PHONENUMBER_FIELD_NUMBER = 3;
    private long phoneNumber_ = 0L;
    /**
     * <code>int64 phoneNumber = 3;</code>
     * @return The phoneNumber.
     */
    @java.lang.Override
    public long getPhoneNumber() {
      return phoneNumber_;
    }

    public static final int EMAIL_FIELD_NUMBER = 4;
    @SuppressWarnings("serial")
    private volatile java.lang.Object email_ = "";
    /**
     * <code>string email = 4;</code>
     * @return The email.
     */
    @java.lang.Override
    public java.lang.String getEmail() {
      java.lang.Object ref = email_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        email_ = s;
        return s;
      }
    }
    /**
     * <code>string email = 4;</code>
     * @return The bytes for email.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getEmailBytes() {
      java.lang.Object ref = email_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int NAMESURNAME_FIELD_NUMBER = 5;
    @SuppressWarnings("serial")
    private com.google.protobuf.LazyStringArrayList nameSurname_ =
            com.google.protobuf.LazyStringArrayList.emptyList();
    /**
     * <code>repeated string nameSurname = 5;</code>
     * @return A list containing the nameSurname.
     */
    public com.google.protobuf.ProtocolStringList
    getNameSurnameList() {
      return nameSurname_;
    }
    /**
     * <code>repeated string nameSurname = 5;</code>
     * @return The count of nameSurname.
     */
    public int getNameSurnameCount() {
      return nameSurname_.size();
    }
    /**
     * <code>repeated string nameSurname = 5;</code>
     * @param index The index of the element to return.
     * @return The nameSurname at the given index.
     */
    public java.lang.String getNameSurname(int index) {
      return nameSurname_.get(index);
    }
    /**
     * <code>repeated string nameSurname = 5;</code>
     * @param index The index of the value to return.
     * @return The bytes of the nameSurname at the given index.
     */
    public com.google.protobuf.ByteString
    getNameSurnameBytes(int index) {
      return nameSurname_.getByteString(index);
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (id_ != 0) {
        output.writeInt32(1, id_);
      }
      if (sex_ != false) {
        output.writeBool(2, sex_);
      }
      if (phoneNumber_ != 0L) {
        output.writeInt64(3, phoneNumber_);
      }
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(email_)) {
        com.google.protobuf.GeneratedMessage.writeString(output, 4, email_);
      }
      for (int i = 0; i < nameSurname_.size(); i++) {
        com.google.protobuf.GeneratedMessage.writeString(output, 5, nameSurname_.getRaw(i));
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeInt32Size(1, id_);
      }
      if (sex_ != false) {
        size += com.google.protobuf.CodedOutputStream
                .computeBoolSize(2, sex_);
      }
      if (phoneNumber_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
                .computeInt64Size(3, phoneNumber_);
      }
      if (!com.google.protobuf.GeneratedMessage.isStringEmpty(email_)) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(4, email_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < nameSurname_.size(); i++) {
          dataSize += computeStringSizeNoTag(nameSurname_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getNameSurnameList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof PersonProtoClass.Person)) {
        return super.equals(obj);
      }
      PersonProtoClass.Person other = (PersonProtoClass.Person) obj;

      if (getId()
              != other.getId()) return false;
      if (getSex()
              != other.getSex()) return false;
      if (getPhoneNumber()
              != other.getPhoneNumber()) return false;
      if (!getEmail()
              .equals(other.getEmail())) return false;
      if (!getNameSurnameList()
              .equals(other.getNameSurnameList())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (37 * hash) + SEX_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
              getSex());
      hash = (37 * hash) + PHONENUMBER_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              getPhoneNumber());
      hash = (37 * hash) + EMAIL_FIELD_NUMBER;
      hash = (53 * hash) + getEmail().hashCode();
      if (getNameSurnameCount() > 0) {
        hash = (37 * hash) + NAMESURNAME_FIELD_NUMBER;
        hash = (53 * hash) + getNameSurnameList().hashCode();
      }
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static PersonProtoClass.Person parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PersonProtoClass.Person parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PersonProtoClass.Person parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PersonProtoClass.Person parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PersonProtoClass.Person parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static PersonProtoClass.Person parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static PersonProtoClass.Person parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
              .parseWithIOException(PARSER, input);
    }
    public static PersonProtoClass.Person parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static PersonProtoClass.Person parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
              .parseDelimitedWithIOException(PARSER, input);
    }

    public static PersonProtoClass.Person parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static PersonProtoClass.Person parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
              .parseWithIOException(PARSER, input);
    }
    public static PersonProtoClass.Person parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessage
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(PersonProtoClass.Person prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Person}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:Person)
            PersonProtoClass.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return PersonProtoClass.internal_static_Person_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return PersonProtoClass.internal_static_Person_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        PersonProtoClass.Person.class, PersonProtoClass.Person.Builder.class);
      }

      // Construct using PersonProtoClass.Person.newBuilder()
      private Builder() {

      }

      private Builder(
              com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        id_ = 0;
        sex_ = false;
        phoneNumber_ = 0L;
        email_ = "";
        nameSurname_ =
                com.google.protobuf.LazyStringArrayList.emptyList();
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return PersonProtoClass.internal_static_Person_descriptor;
      }

      @java.lang.Override
      public PersonProtoClass.Person getDefaultInstanceForType() {
        return PersonProtoClass.Person.getDefaultInstance();
      }

      @java.lang.Override
      public PersonProtoClass.Person build() {
        PersonProtoClass.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public PersonProtoClass.Person buildPartial() {
        PersonProtoClass.Person result = new PersonProtoClass.Person(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(PersonProtoClass.Person result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.id_ = id_;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.sex_ = sex_;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.phoneNumber_ = phoneNumber_;
        }
        if (((from_bitField0_ & 0x00000008) != 0)) {
          result.email_ = email_;
        }
        if (((from_bitField0_ & 0x00000010) != 0)) {
          nameSurname_.makeImmutable();
          result.nameSurname_ = nameSurname_;
        }
      }

      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof PersonProtoClass.Person) {
          return mergeFrom((PersonProtoClass.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(PersonProtoClass.Person other) {
        if (other == PersonProtoClass.Person.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (other.getSex() != false) {
          setSex(other.getSex());
        }
        if (other.getPhoneNumber() != 0L) {
          setPhoneNumber(other.getPhoneNumber());
        }
        if (!other.getEmail().isEmpty()) {
          email_ = other.email_;
          bitField0_ |= 0x00000008;
          onChanged();
        }
        if (!other.nameSurname_.isEmpty()) {
          if (nameSurname_.isEmpty()) {
            nameSurname_ = other.nameSurname_;
            bitField0_ |= 0x00000010;
          } else {
            ensureNameSurnameIsMutable();
            nameSurname_.addAll(other.nameSurname_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 8: {
                id_ = input.readInt32();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
              case 16: {
                sex_ = input.readBool();
                bitField0_ |= 0x00000002;
                break;
              } // case 16
              case 24: {
                phoneNumber_ = input.readInt64();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
              case 34: {
                email_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000008;
                break;
              } // case 34
              case 42: {
                java.lang.String s = input.readStringRequireUtf8();
                ensureNameSurnameIsMutable();
                nameSurname_.add(s);
                break;
              } // case 42
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private int id_ ;
      /**
       * <code>int32 id = 1;</code>
       * @return The id.
       */
      @java.lang.Override
      public int getId() {
        return id_;
      }
      /**
       * <code>int32 id = 1;</code>
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(int value) {

        id_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>int32 id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0;
        onChanged();
        return this;
      }

      private boolean sex_ ;
      /**
       * <code>bool sex = 2;</code>
       * @return The sex.
       */
      @java.lang.Override
      public boolean getSex() {
        return sex_;
      }
      /**
       * <code>bool sex = 2;</code>
       * @param value The sex to set.
       * @return This builder for chaining.
       */
      public Builder setSex(boolean value) {

        sex_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <code>bool sex = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearSex() {
        bitField0_ = (bitField0_ & ~0x00000002);
        sex_ = false;
        onChanged();
        return this;
      }

      private long phoneNumber_ ;
      /**
       * <code>int64 phoneNumber = 3;</code>
       * @return The phoneNumber.
       */
      @java.lang.Override
      public long getPhoneNumber() {
        return phoneNumber_;
      }
      /**
       * <code>int64 phoneNumber = 3;</code>
       * @param value The phoneNumber to set.
       * @return This builder for chaining.
       */
      public Builder setPhoneNumber(long value) {

        phoneNumber_ = value;
        bitField0_ |= 0x00000004;
        onChanged();
        return this;
      }
      /**
       * <code>int64 phoneNumber = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearPhoneNumber() {
        bitField0_ = (bitField0_ & ~0x00000004);
        phoneNumber_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object email_ = "";
      /**
       * <code>string email = 4;</code>
       * @return The email.
       */
      public java.lang.String getEmail() {
        java.lang.Object ref = email_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          email_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string email = 4;</code>
       * @return The bytes for email.
       */
      public com.google.protobuf.ByteString
      getEmailBytes() {
        java.lang.Object ref = email_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          email_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string email = 4;</code>
       * @param value The email to set.
       * @return This builder for chaining.
       */
      public Builder setEmail(
              java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        email_ = value;
        bitField0_ |= 0x00000008;
        onChanged();
        return this;
      }
      /**
       * <code>string email = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearEmail() {
        email_ = getDefaultInstance().getEmail();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }
      /**
       * <code>string email = 4;</code>
       * @param value The bytes for email to set.
       * @return This builder for chaining.
       */
      public Builder setEmailBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        email_ = value;
        bitField0_ |= 0x00000008;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringArrayList nameSurname_ =
              com.google.protobuf.LazyStringArrayList.emptyList();
      private void ensureNameSurnameIsMutable() {
        if (!nameSurname_.isModifiable()) {
          nameSurname_ = new com.google.protobuf.LazyStringArrayList(nameSurname_);
        }
        bitField0_ |= 0x00000010;
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @return A list containing the nameSurname.
       */
      public com.google.protobuf.ProtocolStringList
      getNameSurnameList() {
        nameSurname_.makeImmutable();
        return nameSurname_;
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @return The count of nameSurname.
       */
      public int getNameSurnameCount() {
        return nameSurname_.size();
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @param index The index of the element to return.
       * @return The nameSurname at the given index.
       */
      public java.lang.String getNameSurname(int index) {
        return nameSurname_.get(index);
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @param index The index of the value to return.
       * @return The bytes of the nameSurname at the given index.
       */
      public com.google.protobuf.ByteString
      getNameSurnameBytes(int index) {
        return nameSurname_.getByteString(index);
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @param index The index to set the value at.
       * @param value The nameSurname to set.
       * @return This builder for chaining.
       */
      public Builder setNameSurname(
              int index, java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        ensureNameSurnameIsMutable();
        nameSurname_.set(index, value);
        bitField0_ |= 0x00000010;
        onChanged();
        return this;
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @param value The nameSurname to add.
       * @return This builder for chaining.
       */
      public Builder addNameSurname(
              java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        ensureNameSurnameIsMutable();
        nameSurname_.add(value);
        bitField0_ |= 0x00000010;
        onChanged();
        return this;
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @param values The nameSurname to add.
       * @return This builder for chaining.
       */
      public Builder addAllNameSurname(
              java.lang.Iterable<java.lang.String> values) {
        ensureNameSurnameIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
                values, nameSurname_);
        bitField0_ |= 0x00000010;
        onChanged();
        return this;
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearNameSurname() {
        nameSurname_ =
                com.google.protobuf.LazyStringArrayList.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);;
        onChanged();
        return this;
      }
      /**
       * <code>repeated string nameSurname = 5;</code>
       * @param value The bytes of the nameSurname to add.
       * @return This builder for chaining.
       */
      public Builder addNameSurnameBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        ensureNameSurnameIsMutable();
        nameSurname_.add(value);
        bitField0_ |= 0x00000010;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Person)
    }

    // @@protoc_insertion_point(class_scope:Person)
    private static final PersonProtoClass.Person DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new PersonProtoClass.Person();
    }

    public static PersonProtoClass.Person getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Person>
            PARSER = new com.google.protobuf.AbstractParser<Person>() {
      @java.lang.Override
      public Person parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
                  .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<Person> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Person> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public PersonProtoClass.Person getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_Person_descriptor;
  private static final
  com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internal_static_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
  getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
          descriptor;
  static {
    java.lang.String[] descriptorData = {
            "\n\014person.proto\"Z\n\006Person\022\n\n\002id\030\001 \001(\005\022\013\n\003" +
                    "sex\030\002 \001(\010\022\023\n\013phoneNumber\030\003 \001(\003\022\r\n\005email\030" +
                    "\004 \001(\t\022\023\n\013nameSurname\030\005 \003(\tB\022B\020PersonProt" +
                    "oClassb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
            .internalBuildGeneratedFileFrom(descriptorData,
                    new com.google.protobuf.Descriptors.FileDescriptor[] {
                    });
    internal_static_Person_descriptor =
            getDescriptor().getMessageTypes().get(0);
    internal_static_Person_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
            internal_static_Person_descriptor,
            new java.lang.String[] { "Id", "Sex", "PhoneNumber", "Email", "NameSurname", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}